#include <bits/stdc++.h>
using namespace std;

int N;
vector<int> A;
int table[] = {5, 7, 5, 7, 7};

int solve(){
    for(int i=0; i<N; i++){
        bool ok = true;
        int cur = i;
        for(int j=0; j<5; j++){
            int s = 0;
            while(cur<N && s<table[j]){
                s += A[cur++];
            }
            if(table[j] != s){
                ok = false;
                break;
            }
        }
        if(ok)
            return i+1;
    }
    return -1;
}

int main(){
    while(cin >> N, N){
        A.clear();
        for(int i=0; i<N; i++){
            string s; cin >> s;
            A.push_back(s.size());
        }
        cout << solve() << endl;
    }
    return 0;
}