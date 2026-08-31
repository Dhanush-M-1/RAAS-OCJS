#include<iomanip>
#include<limits>
#include<thread>
#include<utility>
#include<iostream>
#include<string>
#include<algorithm>
#include<set>
#include<map>
#include<vector>
#include<stack>
#include<queue>
#include<cmath>
#include<numeric>
#include<cassert>
#include<random>
#include<chrono>
#include<unordered_set>
#include<unordered_map>
#include<fstream>
#include<list>
#include<functional>
#include<bitset>
#include<complex>
#include<tuple>
using namespace std;
typedef unsigned long long int ull;
typedef long long int ll;
typedef pair<ll,ll> pll;
typedef pair<int,int> pi;
typedef pair<double,double> pd;
typedef pair<double,ll> pdl;
#define F first
#define S second
const ll E=1e18+7;
const ll MOD=1000000007;



__int128 parse(string &s) {
    __int128 ret = 0;
    for (int i = 0; i < s.length(); i++)
        if ('0' <= s[i] && s[i] <= '9')
            ret = 10 * ret + s[i] - '0';
    return ret;
}

std::ostream &operator<<(std::ostream &dest, __int128_t value) {
    std::ostream::sentry s(dest);
    if (s) {
        __uint128_t tmp = value < 0 ? -value : value;
        char buffer[128];
        char *d = std::end(buffer);
        do {
            --d;
            *d = "0123456789"[tmp % 10];
            tmp /= 10;
        } while (tmp != 0);
        if (value < 0) {
            --d;
            *d = '-';
        }
        int len = std::end(buffer) - d;
        if (dest.rdbuf()->sputn(d, len) != len) {
            dest.setstate(std::ios_base::badbit);
        }
    }
    return dest;
}


std::istream &operator>>(std::istream &dest, __int128 &value) {
    string s;
    cin>>s;
    value=parse(s);
    return dest;
}

typedef __int128 Int;

int main(){
    Int n,m,a,b,p,q;
    cin>>n>>m>>a>>b>>p>>q;
    if(a==1 && b==1){
        Int sum=p+q;
        Int M=min(m/sum,n);
        Int ans=m-M*sum;
        Int k=m-(M+1)*sum;
        if(k<0){k*=-1;}
        if(M!=n){ans=min(ans,k);}
        cout<<ans<<endl;
    }
    else{
        vector<ll> A;
        Int s=1,t=1;
        int i;
        for(i=0;i<n && s*p+t*q<=m;i++,s*=a,t*=b){
            A.push_back(s*p+t*q);
        }
        if(i<n && s*p+t*q<=m*2){A.push_back(s*p+t*q);}
        vector<ll> B;
        while(A.size()>B.size()){B.push_back(A.back()); A.pop_back();}
        vector<ll> F;
        for(ll i=0;i<(1LL<<A.size());i++){
            ll sum=0;
            for(int t=0;t<A.size();t++){
                if(i>>t&1){sum+=A[t];}
            }
            F.push_back(sum);
        }
        ll ans=m;
        sort(F.begin(),F.end());
        for(ll i=0;i<(1LL<<B.size());i++){
            ll sum=0;
            for(int t=0;t<B.size();t++){
                if(i>>t&1){sum+=B[t];}
            }
            ll rem=m-sum;
            ll idx=lower_bound(F.begin(),F.end(),rem)-F.begin();
            if(idx!=F.size()){ans=min(ans,abs(F[idx]-rem));}
            if(idx!=0){ans=min(ans,abs(rem-F[idx-1]));}
        }
        cout<<ans<<endl;
    }
    
    
    
    return 0;
}

