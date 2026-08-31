#include <bits/stdc++.h>
using namespace std;

int main(){
    int N;
    cin >> N;
    map<string,int> mp;
    for(int i = 0; i < N;i++){
        string S;cin >> S;
        mp[S]++;
    }
    vector<string> ans = {"AC","WA","TLE","RE"};
    
    for(auto a:ans){
        cout << a << " x " << mp[a] << endl;
    }
}