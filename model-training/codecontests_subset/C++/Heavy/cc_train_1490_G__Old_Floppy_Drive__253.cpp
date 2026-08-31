 #include <bits/stdc++.h>
// #include <atcoder/all>

//using namespace atcoder;
//tabaicho  see https://boostjp.github.io/tips/multiprec-int.html   
// #include <boost/multiprecision/cpp_int.hpp>

// using namespace boost::multiprecision;

// cpp_int
// int128_t
// int256_t
// int512_t
// int1024_t

// uint128_t
// uint256_t
// uint512_t
// uint1024_t



#define int long long
 #define inf  1000000007
// #define inf  998244353

 #define pa pair<int,int>
 #define ll long long
 #define PI 3.14159265358979323846
 #define  mp make_pair
 #define  pb push_back
 #define EPS (1e-8)
 
      using namespace std;
                                          
 int dx[8]={0,1,0,-1,1,1,-1,-1};
 int dy[8]={1,0,-1,0,-1,1,1,-1};
                                            
class pa3{
	public:
	int x;
	int y,z;
	pa3(int x=0,int y=0,int z=0):x(x),y(y),z(z) {}
	bool operator < (const pa3 &p) const{
		if(x!=p.x) return x<p.x;
		if(y!=p.y) return y<p.y;
		 return z<p.z;
		//return x != p.x ? x<p.x: y<p.y;
	}
	bool operator > (const pa3 &p) const{
		if(x!=p.x) return x>p.x;
		if(y!=p.y) return y>p.y;
		 return z>p.z;
		//return x != p.x ? x<p.x: y<p.y;
	}
	bool operator == (const pa3 &p) const{
		return x==p.x && y==p.y && z==p.z;
	}
		bool operator != (const pa3 &p) const{
			return !( x==p.x && y==p.y && z==p.z);
	}

};

class pa4{
	public:
	int x;
	int y,z,w;
	pa4(int x=0,int y=0,int z=0,int w=0):x(x),y(y),z(z),w(w) {}
	bool operator < (const pa4 &p) const{
		if(x!=p.x) return x<p.x;
		if(y!=p.y) return y<p.y;
		if(z!=p.z)return z<p.z;
		return w<p.w;
		//return x != p.x ? x<p.x: y<p.y;
	}
	bool operator > (const pa4 &p) const{
		if(x!=p.x) return x>p.x;
		if(y!=p.y) return y>p.y;
		if(z!=p.z)return z>p.z;
		return w>p.w;
		//return x != p.x ? x<p.x: y<p.y;
	}
	bool operator == (const pa4 &p) const{
		return x==p.x && y==p.y && z==p.z &&w==p.w;
	}
		

};
class pa2{
	public:
	int x,y;
	pa2(int x=0,int y=0):x(x),y(y) {}
	pa2 operator + (pa2 p) {return pa2(x+p.x,y+p.y);}
	pa2 operator - (pa2 p) {return pa2(x-p.x,y-p.y);}
	bool operator < (const pa2 &p) const{
		return y != p.y ? y<p.y: x<p.x;
	}
	bool operator > (const pa2 &p) const{
		return x != p.x ? x<p.x: y<p.y;
	}
	bool operator == (const pa2 &p) const{
		return abs(x-p.x)==0 && abs(y-p.y)==0;
	}
	bool operator != (const pa2 &p) const{
		return !(abs(x-p.x)==0 && abs(y-p.y)==0);
	}
		

};



string itos( int i ) {
	ostringstream s ;
	s << i ;
	return s.str() ;
}
 
int Gcd(int v,int b){
	if(v==0) return b;
	if(b==0) return v;
	if(v>b) return Gcd(b,v);
	if(v==b) return b;
	if(b%v==0) return v;
	return Gcd(v,b%v);
}


 int mod;
int extgcd(int a, int b, int &x, int &y) {
    if (b == 0) {
        x = 1;
        y = 0;
        return a;
    }
    int d = extgcd(b, a%b, y, x);
    y -= a/b * x;
    return d;
}
pa operator+(const pa & l,const pa & r) {   
    return {l.first+r.first,l.second+r.second};                                    
}    
pa operator-(const pa & l,const pa & r) {   
    return {l.first-r.first,l.second-r.second};                                    
}  

ostream& operator<<(ostream& os, const vector<int>& VEC){
	for(auto v:VEC)os<<v<<" ";
    return os;
}

ostream& operator<<(ostream& os, const pa& PAI){
	os<<PAI.first<<" : "<<PAI.second;
    return os;
}

ostream& operator<<(ostream& os, const pa3& PAI){
	os<<PAI.x<<" : "<<PAI.y<<" : "<<PAI.z;
    return os;
}

ostream& operator<<(ostream& os, const pa4& PAI){
	os<<PAI.x<<" : "<<PAI.y<<" : "<<PAI.z<<" : "<<PAI.w;
    return os;
}

ostream& operator<<(ostream& os, const vector<pa>& VEC){
	for(auto v:VEC)os<<v<<" ";
    return os;
}


int beki(int wa,int rr,int warukazu){
	if(rr==0) return 1%warukazu;
	if(rr==1) return wa%warukazu;
	wa%=warukazu;
	if(rr%2==1) return ((ll)beki(wa,rr-1,warukazu)*(ll)wa)%warukazu;
	ll zx=beki(wa,rr/2,warukazu);
	return (zx*zx)%warukazu;
}

              
int pr[2100000];
int inv[2100000];



int comb(int nn,int rr){
	if(rr<0 || rr>nn || nn<0) return 0;
	int r=pr[nn]*inv[rr];
	r%=mod;
	r*=inv[nn-rr];
	r%=mod;
	return r;
}

void gya(int ert){
	pr[0]=1;
	for(int i=1;i<=ert;i++){
		pr[i]=((ll)pr[i-1]*i)%mod;
	}
		inv[ert]=beki(pr[ert],mod-2,mod);
	for(int i=ert-1;i>=0;i--){
		inv[i]=(ll)inv[i+1]*(i+1)%mod;
	}
}


                


                
              //   cin.tie(0);
    		//	ios::sync_with_stdio(false);
    			//priority_queue<pa3,vector<pa3>,greater<pa3>> pq;            
                 //sort(ve.begin(),ve.end(),greater<int>());
//    mt19937(clock_per_sec);
  //  mt19937_64 rng(chrono::steady_clock::now().time_since_epoch().count()) ;


void solve(){
int n;
cin>>n;
int q;
	cin>>q;
	vector<int>ve(n);
	
	for(auto &v:ve)cin>>v;
	vector<int>rui=ve;
	for(int i=1;i<n;i++)rui[i]+=rui[i-1];
	int T=rui.back();
	
	for(int i=1;i<n;i++)rui[i]=max(rui[i],rui[i-1]);
	
	
	
	while(q--){
		int x;
		cin>>x;
		
		if(rui.back()>=x){
			cout<<lower_bound(rui.begin(),rui.end(),x)-rui.begin()<<" ";
			continue;
		}
		if(T<=0){
			cout<<-1<<" ";
			continue;
		}
		int sa=x-rui.back();
		int kai=sa/T+!!(sa%T);
		
		int ans=n*kai;
		x-=T*kai;
		cout<<lower_bound(rui.begin(),rui.end(),x)-rui.begin()+ans<<" ";
		
	}
	cout<<endl;
}


signed main(){
	mod=inf;
	cin.tie(0);
	//solve1();
	ios::sync_with_stdio(false);

int n=1;
	cin>>n;
for(int i=0;i<n;i++)solve();
	return 0;

	
}


 