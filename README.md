# capacitor-webview-print

This is a Capacitor plugin for printing the webview. It supports the Web, iOS and Android Platform.

## Install

```bash
npm install @5uper/capacitor-webview-print
npx cap sync
```

## Maintainers

| Maintainer    | GitHub                              |
| ------------- | ----------------------------------- |
| `Yasin Şimşek` | [5uper](https://github.com/5uper) |

## Versions

| Plugin | Capacitor |
| ------ | ------- |
| `6.x.x`| `6.x.x` |

## Configuration

No configuration required for this plugin.

## Example

```ts
import { WebviewPrint } from 'capacitor-webview-print';

public async printWebview(fileName: string): Promise<void> {
  await WebviewPrint.print({ name: fileName });
}

```

## Platform Support

- Web
- iOS
- Android



## API

<docgen-index>

* [`print(...)`](#print)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### print(...)

```typescript
print(options: PrintOptions) => Promise<void>
```

Trigger a webview print event

| Param         | Type                                                  | Description       |
| ------------- | ----------------------------------------------------- | ----------------- |
| **`options`** | <code><a href="#printoptions">PrintOptions</a></code> | The print options |

**Since:** 1.0.0

--------------------


### Interfaces


#### PrintOptions

| Prop       | Type                | Description                                                    | Since |
| ---------- | ------------------- | -------------------------------------------------------------- | ----- |
| **`name`** | <code>string</code> | Name of the file to be printed. This is an required attribute. | 1.0.0 |

</docgen-api>
