#include<bits/stdc++.h>
#include<string>
using namespace std;
int N;
void dfs(string s,char x){
    if(s.length() == N) printf("%s\n", s.c_str());
    else
        for(char c= 'a'; c <= x; c++)
            dfs(s+c,((c == x) ?(char)(x + 1): x));
}
int main(){
    cin >> N;
    dfs("", 'a');
    return 0;
}