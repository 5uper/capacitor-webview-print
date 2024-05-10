import { WebPlugin } from '@capacitor/core';

import type { WebviewPrintPlugin } from './definitions';

export class WebviewPrintWeb extends WebPlugin implements WebviewPrintPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
