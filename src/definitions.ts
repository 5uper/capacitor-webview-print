export interface WebviewPrintPlugin {
  /**
   * Trigger a webview print event
   *
   * @param options The print options
   * @since 1.0.0
   */
  print(options: PrintOptions): Promise<void>;
}

export interface PrintOptions {
  /**
   * Name of the file to be printed. This is an required attribute.
   *
   * @since 1.0.0
   * @example "product.pdf"
   */
  name: string;
}
