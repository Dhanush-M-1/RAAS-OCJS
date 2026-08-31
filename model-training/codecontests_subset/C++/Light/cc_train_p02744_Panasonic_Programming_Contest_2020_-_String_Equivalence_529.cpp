#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int n;

void dfs(int i, string s, char maxc){
    if(i == n){
        cout << s << endl;
        return;
    }
    for(char c = 'a'; c <= maxc+1; c++){
        dfs(i+1, s + c, max(maxc, c));
    }
}

int main(){
    cin >> n;
    dfs(1, "a", 'a');
    return 0;
}