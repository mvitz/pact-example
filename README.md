# Pact Example

**[Pact](https://docs.pact.io) examples for the JVM using [Pact JVM](https://github.com/DiUS/pact-jvm)**

These examples were written for my german
[JavaSPEKTRUM](http://www.javaspektrum.de/) article
"Der Praktiker: Pacta sunt servanda - Consumer-Driven Contracts – Testen von Schnittstellen innerhalb einer Microservices-Architektur".

You can read it online
[here](https://www.innoq.com/de/articles/2016/09/consumer-driven-contracts/)
or download as PDF
[here](http://www.sigs-datacom.de/uploads/tx_dmjournals/vitz_JS_04_16_TaTZ.pdf).


## Run the Example

* Run `mvn integration-test` in the `consumer` subdirectory.
* Note that JSON Pact files were created in `consumer/target/PACTS`
* Run `mvn integration-test` in the `provider` subdirecty.
* Note that this test uses the JSON Pact files in `pact-example/provider/src/test/resources/pacts`.

So to change the contract the consumer team would change the tests in `consumer/src/test`. This
would result in different Pact files. The consumer team would provide them to the provider team.
That way the Pact file would be integrated in the `provider` project. The provider team needs to
assure that the tests pass.


## License

The MIT License (MIT)

Copyright (c) 2016 Michael Vitz

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
associated documentation files (the "Software"), to deal in the Software without restriction,
including without limitation the rights to use, copy, modify, merge, publish, distribute,
sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial
portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES
OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

