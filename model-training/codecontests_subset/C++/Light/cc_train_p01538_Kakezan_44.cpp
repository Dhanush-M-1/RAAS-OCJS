#include<bits/stdc++.h>
#define rep(i,a,b) for(int i=int(a);i<int(b);++i)
using namespace std;
typedef long long ll;
int INF = (1LL << 30) - 1;
int MOD = 1e9+7;
string to_str(ll A){
    stringstream ss;
    ss << A;
    return ss.str();
}
int func(string s){
    if(s.length() == 1)return 0;
    ll maxi = 0;
    rep(i,1,s.length()){
        ll num = stoi(s.substr(0,i) ) * stoi(s.substr(i) );    
        maxi = max(maxi, num);
    }
    return 1 + func(to_str(maxi));
}

int main(){
    int N;
    cin >> N;
    rep(i,0,N){
        int num;
        cin >> num;
        cout << func(to_str(num) ) << endl;
    }
}
