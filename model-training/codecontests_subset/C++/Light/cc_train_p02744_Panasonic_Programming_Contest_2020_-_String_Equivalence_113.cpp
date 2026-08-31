#include "bits/stdc++.h"

using namespace std;

unsigned n;

void f(string s, char up)
{
    if (s.length() == n) {
        cout << s << endl;
        return;
    }

    for (char c = 'a'; c <= up + 1; c++) {
        f(s + c, max(up, c));
    }
}


int main()
{
    cin >> n;
    f("", 'a' - 1);
    return 0;
}
