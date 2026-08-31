#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int n;

void dfs(string s, char maxc){
    if(s.size() == n){
        printf("%s\n", s.c_str());
        return;
    }
    for(char c = 'a'; c <= maxc; c++){
        dfs(s + c, max(maxc, (char)(c+1)));
    }
}

int main(){
    cin >> n;
    dfs("", 'a');
    return 0;
}