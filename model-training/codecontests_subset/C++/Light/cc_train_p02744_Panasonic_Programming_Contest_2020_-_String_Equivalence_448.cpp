#include <bits/stdc++.h>
using namespace std;

int n;
void dfs(string s, char c){
    if(s.size() == n){
        cout << s << endl;
        return;
    }
    for(char i='a'; i<=c; ++i){
        string t = s;
        t += i;
        dfs(t, (i==c)?c+1:c);
    }
}

int main() {

    cin >> n;
    dfs("", 'a');

    return 0;
}