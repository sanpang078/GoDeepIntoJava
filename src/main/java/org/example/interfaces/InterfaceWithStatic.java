package org.example.interfaces;

public interface InterfaceWithStatic {
    public static class IntClass implements InterfaceWithStatic{
        public static int compare(int x, int y)
        {
            return x;
        }
    }
}
