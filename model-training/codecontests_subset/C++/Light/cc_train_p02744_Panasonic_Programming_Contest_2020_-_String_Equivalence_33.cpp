#include <bits/stdc++.h>
using namespace std;

void dfs(string s, int N) {
    if (s.size() == N) {
        cout << s << endl;
        return;
    }
    
    char c = 'a';
    for (char &i : s) c = max(c, i);
    
    for (char i = 'a'; i <= c + 1; ++i) dfs(s + i, N);
}

int main(void){
    int N;
    cin >> N;
    
    dfs("a", N);
}
