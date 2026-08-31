#include <bits/stdc++.h>
using namespace std;

int N;

void solve(string S,char add){
    if(S.length()==N){
        cout<<S<<endl;
    }else{
        for(char i='a';i<=add;i++){
            if(i==add)solve(S+i,add+1);
            else solve(S+i,add);
        }
    }
}

int main() {
    cin >> N;
    solve("",'a');
    return 0;
}