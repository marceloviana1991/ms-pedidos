# PedidoControllerApi

All URIs are relative to *http://192.168.9.212:43839*

Method | HTTP request | Description
------------- | ------------- | -------------
[**aprovaPagamento**](PedidoControllerApi.md#aprovaPagamento) | **PUT** /pedidos/{id}/pago | 
[**getPagePedidos**](PedidoControllerApi.md#getPagePedidos) | **GET** /pedidos | 
[**getPedido**](PedidoControllerApi.md#getPedido) | **GET** /pedidos/{id} | 
[**retornaPorta**](PedidoControllerApi.md#retornaPorta) | **GET** /pedidos/porta | 
[**savePedido**](PedidoControllerApi.md#savePedido) | **POST** /pedidos | 

<a name="aprovaPagamento"></a>
# **aprovaPagamento**
> aprovaPagamento(id)



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PedidoControllerApi;


PedidoControllerApi apiInstance = new PedidoControllerApi();
Long id = 789L; // Long | 
try {
    apiInstance.aprovaPagamento(id);
} catch (ApiException e) {
    System.err.println("Exception when calling PedidoControllerApi#aprovaPagamento");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getPagePedidos"></a>
# **getPagePedidos**
> List&lt;PedidoResponseDto&gt; getPagePedidos(pageable)



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PedidoControllerApi;


PedidoControllerApi apiInstance = new PedidoControllerApi();
Pageable pageable = new Pageable(); // Pageable | 
try {
    List<PedidoResponseDto> result = apiInstance.getPagePedidos(pageable);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PedidoControllerApi#getPagePedidos");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pageable** | [**Pageable**](.md)|  |

### Return type

[**List&lt;PedidoResponseDto&gt;**](PedidoResponseDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getPedido"></a>
# **getPedido**
> PedidoResponseDto getPedido(id)



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PedidoControllerApi;


PedidoControllerApi apiInstance = new PedidoControllerApi();
Long id = 789L; // Long | 
try {
    PedidoResponseDto result = apiInstance.getPedido(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PedidoControllerApi#getPedido");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**|  |

### Return type

[**PedidoResponseDto**](PedidoResponseDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="retornaPorta"></a>
# **retornaPorta**
> String retornaPorta(porta)



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PedidoControllerApi;


PedidoControllerApi apiInstance = new PedidoControllerApi();
String porta = "porta_example"; // String | 
try {
    String result = apiInstance.retornaPorta(porta);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PedidoControllerApi#retornaPorta");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **porta** | **String**|  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="savePedido"></a>
# **savePedido**
> PedidoResponseDto savePedido(body)



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PedidoControllerApi;


PedidoControllerApi apiInstance = new PedidoControllerApi();
PedidoRequestDto body = new PedidoRequestDto(); // PedidoRequestDto | 
try {
    PedidoResponseDto result = apiInstance.savePedido(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PedidoControllerApi#savePedido");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PedidoRequestDto**](PedidoRequestDto.md)|  |

### Return type

[**PedidoResponseDto**](PedidoResponseDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

