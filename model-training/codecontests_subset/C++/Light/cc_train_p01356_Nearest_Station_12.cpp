#include<deque>
#include<queue>
#include<vector>
#include<algorithm>
#include<iostream>
#include<set>
#include<cmath>
#include<tuple>
#include<string>
#include<chrono>
#include<functional>
#include<iterator>
#include<random>
#include<unordered_set>
#include<array>
#include<map>
#include<iomanip>
#include<assert.h>
#include<list>
#include<bitset>
#include<stack>
#include<memory>
#include<numeric>
using namespace std;
using namespace std::chrono;
typedef long long int llint;
typedef long double lldo;
#define mp make_pair
#define mt make_tuple
#define pub push_back
#define puf push_front
#define pob pop_back
#define pof pop_front
#define fir first
#define sec second
#define res resize
#define ins insert
#define era erase
/*cout<<fixed<<setprecision(20);cin.tie(0);ios::sync_with_stdio(false);*/
const llint mod=1000000007 ;
const llint big=2.19e15+1;
const long double pai=3.141592653589793238462643383279502884197;
const long double eps=1e-10;
const long double epsA=1e-4;
template <class T,class U>bool mineq(T& a,U b){if(a>b){a=b;return true;}return false;}
template <class T,class U>bool maxeq(T& a,U b){if(a<b){a=b;return true;}return false;}
llint gcd(llint a,llint b){if(a%b==0){return b;}else return gcd(b,a%b);}
llint lcm(llint a,llint b){if(a==0){return b;}return a/gcd(a,b)*b;}
template<class T> void SO(T& ve){sort(ve.begin(),ve.end());}
template<class T> void REV(T& ve){reverse(ve.begin(),ve.end());}
template<class T>llint LBI(const vector<T>&ar,T in){return lower_bound(ar.begin(),ar.end(),in)-ar.begin();}
template<class T>llint UBI(const vector<T>&ar,T in){return upper_bound(ar.begin(),ar.end(),in)-ar.begin();}
int main(void){
	//ウサギは進みすぎた後徒歩で戻ってもいいんか
	//いったんすべてを決定した後、キャンセルする手法
	llint n,m,a,b,p,q,i;cin>>n>>m>>a>>b>>p>>q;
	llint ans=m;
	if(a>b){swap(p,q);swap(a,b);}
	
	if(a==1&&b==1){
		llint f=min(n,m/(p+q));
		llint fx=min(n,m/(p+q)+1);
		cout<<min(m-f*(p+q),abs(m-fx*(p+q)))<<endl;
	}else{
		//とりあえずnをfixする
		llint pg=p,qg=q,aa=0;
		while(pg+qg<=m*3){
			aa++;
			if(1.0*pg*a+1.0*qg*b>m*4){break;}//オーバーフロー危ない！
			pg*=a;qg*=b;
		}
		mineq(n,aa);
		//cerr<<"n="<<n<<endl;
		if(a==1){
			//cerr<<"a"<<endl;
			//合計枚数を固定して、そこから求める
			llint mai[80];
			qg=q;
			llint wa=0;
			for(i=0;i<n;i++){mai[i]=qg;wa+=mai[i];qg*=b;}
			wa+=n*p;
			for(int h=0;h<=n;h++){
				//枚数を固定する
				llint gen=m-h*p;
				for(i=0;i<h;i++){gen-=mai[i];}
				
				
				//maiでうまく貪欲法
				llint rest=h;
				for(i=n-1;i>=0;i--){
					if(rest<=0){break;}
					if(i<rest){break;}
					if(gen>=mai[i]-mai[rest-1]){gen-=mai[i]-mai[rest-1];rest--;}
				}
				mineq(ans,abs(gen));
				
				gen=wa-(m-h*p);
				for(i=0;i<h;i++){gen-=mai[i];}
				if(gen<0){continue;}
				//maiでうまく貪欲法
				rest=h;
				for(i=n-1;i>=0;i--){
					if(rest<=0){break;}
					if(i<rest){break;}
					if(gen>=mai[i]-mai[rest-1]){gen-=mai[i]-mai[rest-1];rest--;}
				}
				mineq(ans,abs(gen));
				
			}
			cout<<ans<<endl;
		}else{
			llint mai[80];
			qg=q;pg=p;
			llint wa=0;
			for(i=0;i<n;i++){mai[i]=qg+pg;wa+=mai[i];pg*=a;qg*=b;}
			llint gen=m;
			for(i=n-1;i>=0;i--){
				//cerr<<"gen="<<gen<<endl;
				if(gen>=mai[i]){gen-=mai[i];}
			}
			mineq(ans,abs(gen));
			gen=wa-m;
			for(i=n-1;i>=0;i--){
				//cerr<<"gen="<<gen<<endl;
				if(gen>=mai[i]){gen-=mai[i];}
			}
			mineq(ans,abs(gen));
			cout<<ans<<endl;
		}
	}
	return 0;
}
/*
1 2 4 8 16
10000000000
*/
