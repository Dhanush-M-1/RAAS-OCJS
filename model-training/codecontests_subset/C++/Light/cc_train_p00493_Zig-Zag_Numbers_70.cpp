#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef long double ld;
typedef pair<ll,ll> P;
typedef pair<int,int> Pi;
#define rep(i, n) for (ll i = 0; i < n; i++)
#define FOR(i, a, b) for (ll i = a; i < b; i++)
#define fi first
#define se second
#define endl "\n"

template<typename T> inline bool chmax(T &a, T b){if(a<b){a=b;return true;}return false;}
template<typename T> inline bool chmin(T &a, T b){if(a>b){a=b;return true;}return false;}
template<typename T> ostream& operator<<(ostream& s,const complex<T>& d) {return s<<"("<<d.real()<<", "<<d.imag()<< ")";}
template<typename T1, typename T2> ostream& operator<<(ostream& s,const pair<T1,T2>& d) {return s<<"("<<d.first<<", "<<d.second<<")";}
template<typename T> ostream& operator<<(ostream& s, const vector<T>& d){
	int len=d.size();
	rep(i,len){
		s<<d[i];if(i<len-1) s<<" ";
	}
	return s;
}
template<typename T> ostream& operator<<(ostream& s,const vector<vector<T>>& d){
	int len=d.size();
	rep(i,len){
		s<<d[i]<<endl;
	}
	return s;
}
template<typename T> ostream& operator<<(ostream& s,const set<T>& v){
	s<<"{ ";
	for(auto itr=v.begin();itr!=v.end();++itr) {
		if (itr!=v.begin()) {s<< ", ";}
		s<<(*itr);
	}
	s<<" }";
	return s;
}
template<typename T1, typename T2> ostream& operator<<(ostream& s,const map<T1,T2>& m){
	s<<"{"<<endl;
	for(auto itr=m.begin();itr!=m.end();++itr){
		s<<" "<<(*itr).first<<" : "<<(*itr).second<<endl;
	}
	s<<"}"<<endl;
	return s;
}

const ll mod=10000;
const ll inf=1e17;
const int INF=1e9;
const double PI=acos(-1);
const double EPS=1e-10;

struct mint {
    ll x;
    mint(ll x=0):x((x%mod+mod)%mod){}
    mint& operator+=(const mint a) {
        if ((x += a.x) >= mod) x -= mod;
        return *this;
    }
    mint& operator-=(const mint a) {
        if ((x += mod-a.x) >= mod) x -= mod;
        return *this;
    }
    mint& operator*=(const mint a) {
        (x *= a.x) %= mod;
        return *this;
    }
    mint operator+(const mint a) const {
        mint res(*this);
        return res+=a;
    }
    mint operator-(const mint a) const {
        mint res(*this);
        return res-=a;
    }
    mint operator*(const mint a) const {
        mint res(*this);
        return res*=a;
    }
    mint pow(ll t) const {
        if (!t) return 1;
        mint a = pow(t>>1);
        a *= a;
        if (t&1) a *= *this;
        return a;
    }
    // for prime mod
    mint inv() const {
        return pow(mod-2);
    }
    mint& operator/=(const mint a) {
        return (*this) *= a.inv();
    }
    mint operator/(const mint a) const {
        mint res(*this);
        return res/=a;
    }
};

int m;
mint dp[510][2][10][510][4];
/*
決定している桁数
x以下が確定しているか 0:まだ 1:確定
前の桁に置かれた数字
mで割った余り
単調増加かどうか 0:1桁だけ確定 1:増加 2:減少 3:まだ確定していない
*/

mint solve(string x){
	rep(i,510)rep(j,2)rep(k,10)rep(l,510)rep(n,4) dp[i][j][k][l][n]=0;
	dp[0][0][0][0][3]=1;
	rep(i,x.size())rep(a,2)rep(b,10)rep(c,m)rep(d,4){
		int now=x[i]-'0';
		rep(nb,10){
			int na=a,nc=c,nd=d;
			if(a==0 && now<nb) continue;//xより大きな値はダメ
			if(nb<now) na=1;//xより小さいことが確定したら
			if(d==3){//何も決まっていない状態からは1桁確定した状態に遷移する
				if(nb==0) nd=3;
				else nd=0;
				nc=nb%m;
			}
			if(d==0){//1桁確定した状態からは2桁確定した状態へ
				if(b==nb) continue;
				if(b<nb) nd=1;
				if(b>nb) nd=2;
			}
			if(d==2){//減少してたところからは増加に
				nd=1;
				if(b>=nb) continue;
			}
			if(d==1){
				nd=2;
				if(b<=nb) continue;
			}
			nc=(10*c+nb)%m;
			dp[i+1][na][nb][nc][nd]+=dp[i][a][b][c][d];
		}
	}
	mint ret=0;
	rep(a,2)rep(b,10)rep(d,3) ret+=dp[x.size()][a][b][0][d];
	//cout<<ret.x<<endl;
	return ret;
}

int main(){
	cin.tie(0);
	ios::sync_with_stdio(false);
	string a,b;
	cin>>a>>b>>m;
	int ind=a.size()-1;
	while(true){
		int now=a[ind]-'0';
		if(now>=1){
			now--;
			a[ind]=now+'0';
			break;
		}else{
			a[ind]='9';
			ind--;
		}
	}
	mint ans=solve(b)-solve(a);
	cout<<ans.x<<endl;
}
