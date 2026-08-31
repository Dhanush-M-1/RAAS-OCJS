#include <bits/stdc++.h>
using namespace std;

int n;

void dfs(string s, char mx) {
    if (s.length() == n) {
        printf("%s\n", s.c_str());
    } else {
        for (char c = 'a'; c <= mx; ++c) {
            dfs(s + c, c == mx ? (mx + 1) : mx);
        }
    }
}

int main() {
    scanf("%d", &n);
    dfs("", 'a');
    return 0;
}
