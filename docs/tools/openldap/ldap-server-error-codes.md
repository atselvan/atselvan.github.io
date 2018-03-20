# Server-Side Error Codes

Various LDAP specifications define a number of common result codes that may be included in responses to clients. These result codes include (but are not necessarily limited to):

## 0: Success

This indicates that the operation completed successfully. It may be returned in response to an add, bind, delete, extended, modify, modify DN, or search operations.

Compare operations will not return a success result. If a compare operation does not encounter an error during processing, then the server should return a result of either "compare true" or "compare false", based on whether the target entry had the specified attribute value.

## 1: Operations Error

This is intended to indicate that the client has requested an operation at an inappropriate time or in an incorrect order. For example, it may be used if a client sends a non-bind request in the middle of a multi-stage bind operation.

Note that some directory servers use this as a generic "server error" type result. This is not the intended use for this result code (the "other" result is a better choice for this), but clients may need to be aware of this possibility.

## 2: Protocol Error

This generally indicates that the client request was improperly formatted in some way. For a bind operation, it may indicate that the client attempted to use an unsupported LDAP protocol version. For an extended operation, it may indicate that the server does not support the extended request type.

Note that this result code can only be used if the server is able to at least partially decode the request in order to determine the message ID and operation type, since the server needs that information in order to craft an appropriate response.

## 3: Time Limit Exceeded

This indicates that a search operation took longer to complete than allowed by the maximum time limit for that operation. This may be the time limit specified by the client in the search request, or it may be a time limit imposed by the server.

## 4: Size Limit Exceeded

This indicates that a search operation would have returned more entries than were allowed for that operation. This may be the size limit specified by the client in the search request, or it may be a size limit imposed by the server. Note that the server may return a portion of the matching entries before this result.

## 5: Compare False

This indicates that a compare operation was processed successfully but that the target entry did not match the provided attribute value assertion.

## 6: Compare True

This indicates that a compare operation was processed successfully and that the target entry matched the provided attribute value assertion.

## 7: Authentication Method Not Supported

This indicates that a bind operation failed because the server does not support the requested authentication type.

## 8: Stronger Authentication Required

This indicates that the server requires that the client be authenticated with a stronger mechanism than has previously been performed in order to process the request.

This result code may be used in a notice of disconnection unsolicited notification if the server believes that the security of the connection has been compromised.

## 10: Referral

This indicates that the server could not process the requested operation, but that it may succeed if attempted in another location, as specified by the referral URIs included in the response.

## 11: Administrative Limit Exceeded

This indicates that an administrative limit was exceeded while processing the request. For example, some directory servers use this response to indicate that it would have required examining too many entries to process the request.

## 12: Unavailable Critical Extension

This indicates that the request included a critical control that was not recognized or could not be processed.

## 13: Confidentiality Required

This indicates that the requested operation is only allowed over a secure connection.

## 14: SASL Bind in Progress

This indicates that the server requires more information from the client in order to complete the SASL bind operation. In such responses, the "server SASL credentials" element of the result message will often include information the client needs for subsequent phases of bind processing.

## 16: No Such Attribute

This indicates that the client attempted to interact with an attribute that does not exist in the target entry (e.g., to remove an attribute or value that does not exist).

## 17: Undefined Attribute Type

This indicates that the client request included an attribute type that is not defined in the server schema.

## 18: Inappropriate Matching

This indicates that the client request attempted to perform an unsupported type of matching against an attribute. For example, this may be used if the attribute type does not have an appropriate matching rule for the type of matching requested for that attribute.

## 19: Constraint Violation

This indicates that the client request would have caused the server to violate some constraint defined in the server (e.g., to add more than one value to a single-valued attribute).

## 20: Attribute or Value Exists

This indicates that the client request attempted to add an attribute or value to an entry that already contained that attribute or value.

## 21: Invalid Attribute Syntax

This indicates that the client request would have resulted in an attribute value that did not conform to the syntax for that attribute type.

## 32: No Such Object

This indicates that the client request targeted an entry that does not exist. Note that some servers use this result for a bind request that targets a nonexistent user, even though "invalid credentials" is a more appropriate result for that case.

## 33: Alias Problem

This indicates that a problem was encountered while interacting with an alias entry (e.g., the alias refers to an entry that does not exist).

## 34: Invalid DN Syntax

This indicates that the request included a malformed or invalid DN or RDN.

## 36: Alias Dereferencing Problem

This indicates that the client attempted to interact with an alias entry in a manner that was not allowed (e.g., for an operation that does not allow the use of aliases, or if the client does not have permission to access the entry referenced by the alias).

## 48: Inappropriate Authentication

This indicates that the client attempted to perform a type of authentication that is not allowed for the target user (e.g., because the user does not have the necessary credentials for that type of authentication). This may also indicate that the client attempted to perform anonymous authentication when that is not allowed.

## 49: Invalid Credentials

This indicates that the client attempted to bind as a user that does not exist, attempted to bind as a user that is not allowed to bind (e.g., because it has expired, because it has been locked because of too many failed authentication attempts, etc.), or attempted to bind with credentials that were not correct for the target user.

## 50: Insufficient Access Rights

This indicates that the client does not have permission to perform the requested operation.

## 51: Busy

This indicates that the server is currently too busy to process the requested operation.

## 52: Unavailable

This indicates that the server is currently unavailable (e.g., because it is being shut down or is in a maintenance state).

## 53: Unwilling to Perform

This indicates that the server is unwilling to process the requested operation for some reason.

## 54: Loop Detected

This indicates that the server has detected an internal loop while processing the requested operation (e.g., if two alias entries reference each other).

## 60: Sort Control Missing

This indicates that the search request included a virtual list view request control without also including the required server-side sort request control.

## 61: Offset Range Error

This indicates that the search request included a virtual list view request control with an invalid offset or content count.

## 64: Naming Violation

This indicates that the requested add or modify DN operation would have resulted in an entry that violates server naming restrictions (e.g., as might be imposed by a name form defined in the server schema).

## 65: Object Class Violation

This indicates that the requested operation would have resulted in an entry that violates schema restrictions imposed by its object classes (e.g., to include an attribute that is not allowed to be present in the entry, or to omit an attribute that is required to be present in the entry).

## 66: Not Allowed on Non-Leaf Entry

This indicates that the requested operation cannot be performed against an entry that has one or more subordinate entries. For example, a delete operation is normally not allowed to remove an entry that has one or more subordinates.

## 67: Not Allowed on RDN

This indicates that the requested operation is not allowed because it would have altered the entry to remove an attribute value used in the entry's RDN.

## 68: Entry Already Exists

This indicates that the requested add or modify DN operation could not be processed because another entry already exists with the DN that would have resulted from that operation.

## 69: Object Class Modifications Prohibited

This indicates that the requested operation would have resulted in a disallowed change to the object classes contained in the entry (e.g., the operation would have changed the entry's structural object class).

## 71: Affects Multiple DSAs

This indicates that the requested operation could not be processed because it would have required interacting with data in multiple directory server instances in a way that is not supported.

## 76: Virtual List View Error

This indicates that a search operation failed because of processing associated with a virtual list view request control included in the request (e.g., if a necessary index was not in place to facilitate the virtual list view processing).

## 80: Other

This indicates that some problem was encountered during processing that is not covered by any of the other defined result codes (e.g., a server error).

## 118: Canceled

This indicates that an operation was canceled through the use of the cancel extended request. If an operation is canceled in this way, then this result code will be used for both the operation that was canceled and for the cancel extended operation itself.

## 119: No Such Operation

This indicates that an attempt to cancel an operation via the cancel extended request was not successful because the server did not have any knowledge of the target operation. This often means that the server had already completed processing for the operation by the time it received and attempted to process the cancel request.

## 120: Too Late

This indicates that an attempt to cancel an operation via the cancel extended request was not successful because processing for that operation had already reached a point beyond which it could be canceled.

## 121: Cannot Cancel

This indicates that an attempt to cancel an operation via the cancel extended request was not successful because the target operation is not an operation that can be canceled. Operations that cannot be canceled include abandon, bind, unbind, and the cancel and StartTLS extended operations.

## 122: Assertion Failed

This indicates that the requested operation could not be processed because the request included an LDAP assertion request control, but the assertion filter did not match the target entry.

## 123: Authorization Denied

This indicates that the requested operation could not be processed because the request included a proxied authorization request control (or some similar control intended to specify an alternate authorization identity for the operation), but the client was not allowed to request the use of that alternate authorization identity.

## 4096: Synchronization Refresh Required

This indicates that an attempt to use the content synchronization request control in order to perform an incremental update failed for some reason and the client will instead need to request an initial content.

## 16654: No Operation

This indicates that the associated operation would likely have succeeded, to the extent that the server was able to make the determination, but was not actually processed because the request included the LDAP no operation control. Note that at present, the numeric value for this result code is not an official standard because the specification for the no operation request control has not progressed far enough to be assigned an official numeric value, but the value 16654 is in common use by a number of servers for this purpose.