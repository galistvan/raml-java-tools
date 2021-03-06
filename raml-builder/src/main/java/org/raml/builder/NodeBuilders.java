package org.raml.builder;

import org.raml.yagi.framework.nodes.KeyValueNodeImpl;
import org.raml.yagi.framework.nodes.Node;
import org.raml.yagi.framework.nodes.StringNodeImpl;

/**
 * Created. There, you have it.
 */
public class NodeBuilders {

    public static NodeBuilder key(final String key, final String value) {

        return new NodeBuilder() {
            @Override
            public Node buildNode() {
                return new KeyValueNodeImpl(new StringNodeImpl(key), new StringNodeImpl(value));
            }
        };
    }

    public static NodeBuilder property(final String key, final String value) {

        return new NodeBuilder() {
            @Override
            public Node buildNode() {
                return new KeyValueNodeImpl(new StringNodeImpl(key), new StringNodeImpl(value));
            }
        };
    }

    public static NodeBuilder arrayProperty(final String name, final String... values) {

        return new NodeBuilder() {
            @Override
            public Node buildNode() {
                SimpleArrayNode san = new SimpleArrayNode();
                for (String value : values) {
                    san.addChild(new StringNodeImpl(value));
                }
                return new KeyValueNodeImpl(new StringNodeImpl(name), san);
            }
        };
    }

}
