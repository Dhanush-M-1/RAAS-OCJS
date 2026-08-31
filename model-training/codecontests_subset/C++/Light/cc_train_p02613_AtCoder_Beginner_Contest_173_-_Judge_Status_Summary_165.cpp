#include <bits/stdc++.h>
using namespace std;

int main(){
    int N; cin >> N;
    int i;
    map <string,int> cnt;
    string S;
    for(i = 0;i < N;i++){
        cin >> S;
        cnt[S]++;
    }
    for(string s : {"AC","WA","TLE","RE"}){
       cout << s << " x " << cnt[s] << endl;
    }
   

    return 0;
}