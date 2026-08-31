#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int N;

void dfs(string str, char x) {
    if (str.length() == N) {
        cout << str << endl;
    } else {
        for (char c = 'a'; c <= x; c++) {
            dfs(str + c, max((char)(c+1), x));
        }
    }
}

int main() {
    cin>> N;
    dfs("", 'a');
}
