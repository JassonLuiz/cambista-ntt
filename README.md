# cambista-ntt

Api baseada em um arquitetura orientada a eventos para vendas de ingresso online com contadores de disponibilidades atualizados em tempo real

- para cada evento cadastrado teremos uma quantidade total de ingressos que podem ser vendidos
- a cada compra é debitada menos 1 do total
- a cada cancelamento/estornos é acrescentado 1 no total
- todas as transações ocorrerão de forma assíncrona


## infra
- ecs fargate
- apigateway
- dynamodb
- sqs
- sns
- ses

## aplicação
- openjdk 17
- springboot
- api de log por aspect
- endpoints
- dynamodb

