#include<bits/stdc++.h>
using namespace std;

int main(){
    int n,m,a;
    cin >> n >> m;
    vector<int> dp(n+1);
    vector<bool> h(n+1,true);
    for(int i=0;i<m;i++){
        cin >> a;
        h.at(a)=false;
    }
    dp.at(0)=1;dp.at(1)=h.at(1);
    for(int i=2;i<=n;i++){
        dp.at(i)=(dp.at(i-2)*h.at(i-2)+dp.at(i-1)*h.at(i-1))%1000000007;
    }
    cout << dp.at(n) << endl;
    return 0;
}