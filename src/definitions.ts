export interface WebviewPrintPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
