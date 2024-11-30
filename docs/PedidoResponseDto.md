# PedidoResponseDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Long** |  |  [optional]
**dataHora** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**status** | [**StatusEnum**](#StatusEnum) |  |  [optional]
**itens** | [**List&lt;ItemDoPedidoResponseDto&gt;**](ItemDoPedidoResponseDto.md) |  |  [optional]

<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
CRIADO | &quot;CRIADO&quot;
CONFIRMADO | &quot;CONFIRMADO&quot;
