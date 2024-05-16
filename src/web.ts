import { WebPlugin } from '@capacitor/core';

import type { PrintOptions, WebviewPrintPlugin } from './definitions';

export class WebviewPrintWeb extends WebPlugin implements WebviewPrintPlugin {
  async print(options: PrintOptions): Promise<void> {
    const documentTitleTemp = document.title;
    document.title = options.name;

    window.onafterprint = () => (document.title = documentTitleTemp);

    return window.print();
  }
}
