#include <bits/stdc++.h>

using namespace std;

#define _for(i,j,N) for(int i = (j);i < (N);i++)
#define _rep(i,j,N) for(int i = (j);i <= (N);i++)
#define ALL(x) x.begin(),x.end()
#define pb push_back
#define LL long long

template<typename T>
ostream& operator<<(ostream& os,const vector<T>& v) {
    _for(i,0,(int)(v.size()-1)) os << v[i] << " ";
    os << v[v.size()-1];
    return os;
}

template<typename T>
ostream& operator<<(ostream& os,const set<T>& v){
    for(typename set<T>::iterator it = v.begin();it != v.end();it++)
    os << *it <<" ";
    return os;
}

const int maxn = 2e5+5;
LL N,D;
LL A[maxn];
LL R[maxn];

LL fee(int l,int r){
    return (r - l)*D + A[l] + A[r];
}



int main()
{
    cin >> N >> D;
    _rep(i,1,N){
        cin >> A[i];
    }
    R[N] = N;
    for(int i = N-1; i>= 0;i--){
        LL bef = R[i+1];
        if( (bef - i)*D + A[bef] > A[i]){
            R[i] = i;
        }
        else R[i] = bef;
    }


    LL ans = 0;
    int l = 1;
    int ll = 1;
    int r = 2;
    while(l < N){
        r = R[r];
        ans += fee(ll,r);
        _for(i,l+1,r){
            ans += min(fee(ll,i),fee(i,r));
        }
        l = r;
        if((l - ll)*D + A[ll] >= A[l]){
            ll = r;
        }
        r++;
    }
    cout << ans << endl;


    return 0;
}
