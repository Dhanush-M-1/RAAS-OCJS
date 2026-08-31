#include <bits/stdc++.h>
using namespace std;

int N;

void dfs(string s, char mx) {
    if (s.length() == N) {
        cout << s.c_str() << endl;
    } else {
        for (char c = 'a'; c <= mx; c++) {
            dfs(s + c, ((c == mx) ? (char)(mx + 1) : mx));
        }
    }
}

int main() {
    cin >> N;
    dfs("", 'a');
    return 0;
}