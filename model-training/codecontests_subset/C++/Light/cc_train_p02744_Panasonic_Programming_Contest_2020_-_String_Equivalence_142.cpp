#include <bits/stdc++.h>
using namespace std;

int N;

void DFS(string S, char mx){
    if(S.size() == N){
        cout << S << endl;
        return;
    }
    for(char i = 'a'; i <= mx + 1; i++){
        string t = S;
        t += i;
        DFS(t, max(mx, i));
    }
}

int main(){
    cin >> N;
    DFS("", 'a' - 1);
    return 0;
}