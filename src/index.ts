import { registerPlugin } from '@capacitor/core';

import type { WebviewPrintPlugin } from './definitions';

const WebviewPrint = registerPlugin<WebviewPrintPlugin>('WebviewPrint', {
  web: () => import('./web').then(m => new m.WebviewPrintWeb()),
});

export * from './definitions';
export { WebviewPrint };
