#include <bits/stdc++.h>
using namespace std;
int N;

void solve(string s, int k) {
    if(s.size() == N) {
        cout << s << '\n';
        return;
    } else {
        for(int i=0; i<=k+1; ++i) {
            solve(s + (char)((int)'a' + i), max(k, i));
        }
    }
}

int main() {
    cin >> N; solve("a", 0);
}