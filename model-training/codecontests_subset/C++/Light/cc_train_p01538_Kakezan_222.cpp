#include <bits/stdc++.h>
using namespace std;
int memo[1000001];
int calc(int n) {
    if(memo[n]!=-1) return memo[n];
    if(n<10) return 0;
    string s=to_string(n);
    int to=0;
    for(int i=1;i<=s.size()-1;i++) {
        to=max(to,stoi(s.substr(0,i))*stoi(s.substr(i)));
    }
    return memo[n]=calc(to)+1;
}
int main() {
    int Q,N;
    scanf("%d",&Q);
    memset(memo,-1,sizeof(memo));
    for(int i=0;i<Q;i++) {
        scanf("%d",&N);
        printf("%d\n",calc(N));
    }
}