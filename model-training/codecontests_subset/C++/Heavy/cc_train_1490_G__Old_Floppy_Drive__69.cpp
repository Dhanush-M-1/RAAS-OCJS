#include <bits/stdc++.h>
#define all(v) v.begin(), v.end()
#define rall(v) v.rbegin(), v.rend()
#define rep(i,n) for (int i=0;i<(int)(n);i++)
#define codefor int test;scanf("%d",&test);while(test--)
#define INT(...) int __VA_ARGS__;in(__VA_ARGS__)
#define LL(...) ll __VA_ARGS__;in(__VA_ARGS__)
#define yes(ans) if(ans)printf("yes\n");else printf("no\n")
#define Yes(ans) if(ans)printf("Yes\n");else printf("No\n")
#define YES(ans) if(ans)printf("YES\n");else printf("NO\n")
#define vector1d(type,name,...) vector<type>name(__VA_ARGS__)
#define vector2d(type,name,h,...) vector<vector<type>>name(h,vector<type>(__VA_ARGS__))
#define umap unordered_map
#define uset unordered_set
using namespace std;
using ll = long long;
const int MOD=1000000007;
const int MOD2=998244353;
const int INF=1<<30;
const ll INF2=(ll)1<<60;
//入力系
void scan(int& a){scanf("%d",&a);}
void scan(long long& a){scanf("%lld",&a);}
template<class T,class L>void scan(pair<T, L>& p){scan(p.first);scan(p.second);}
template<class T> void scan(T& a){cin>>a;}
template<class T> void scan(vector<T>& vec){for(auto&& it:vec)scan(it);}
void in(){}
template <class Head, class... Tail> void in(Head& head, Tail&... tail){scan(head);in(tail...);}
//出力系
void print(const int& a){printf("%d",a);}
void print(const long long& a){printf("%lld",a);}
void print(const double& a){printf("%.15lf",a);}
template<class T,class L>void print(const pair<T, L>& p){print(p.first);putchar(' ');print(p.second);}
template<class T> void print(const T& a){cout<<a;}
template<class T> void print(const vector<T>& vec){if(vec.empty())return;print(vec[0]);for(auto it=vec.begin();++it!= vec.end();){putchar(' ');print(*it);}}
void out(){putchar('\n');}
template<class T> void out(const T& t){print(t);putchar('\n');}
template <class Head, class... Tail> void out(const Head& head,const Tail&... tail){print(head);putchar(' ');out(tail...);}
//デバッグ系
template<class T> void dprint(const T& a){cerr<<a;}
template<class T> void dprint(const vector<T>& vec){if(vec.empty())return;cerr<<vec[0];for(auto it=vec.begin();++it!= vec.end();){cerr<<" "<<*it;}}
void debug(){cerr<<endl;}
template<class T> void debug(const T& t){dprint(t);cerr<<endl;}
template <class Head, class... Tail> void debug(const Head& head, const Tail&... tail){dprint(head);cerr<<" ";debug(tail...);}
ll intpow(ll a, ll b){ ll ans = 1; while(b){ if(b & 1) ans *= a; a *= a; b /= 2; } return ans; }
ll modpow(ll a, ll b, ll p){ ll ans = 1; while(b){ if(b & 1) (ans *= a) %= p; (a *= a) %= p; b /= 2; } return ans; }
ll updivide(ll a,ll b){if(a%b==0) return a/b;else return (a/b)+1;}
template<class T> void chmax(T &a,const T b){if(b>a)a=b;}
template<class T> void chmin(T &a,const T b){if(b<a)a=b;}

int main(){
    codefor{
        INT(n,m);
        ll minv=0,cycle,l,r,mid,index;
        vector<ll> a(n),b(m),sumv(n,0),ans(m,-1);
        in(a,b);
        sumv[0]=a[0];
        for(int i=1;i<n;i++){
            sumv[i]=sumv[i-1]+a[i];
        }
        cycle=sumv[n-1];
        minv=a[0];
        for(int i=0;i<n;i++){
            chmax(sumv[i],minv);
            chmax(minv,sumv[i]);
        }
        rep(i,m){
            mid=(lower_bound(all(sumv),b[i])-sumv.begin());
            if(mid<n){
                ans[i]=mid;
                continue;
            }else if(cycle<=0){
                continue;
            }
            l=0,r=(INF2/(16*cycle));
            ans[i]=INF2;
            while(l<r){
                mid=(l+r)/2;
                index=(lower_bound(all(sumv),b[i]-cycle*mid)-sumv.begin());
                if(index<n){
                    if(mid<=INF2/n)chmin(ans[i],(ll)index+n*mid);
                    r=mid;
                }else l=mid+1;
            }
            /*debug("{",l);
            ans[i]=(lower_bound(all(sumv),b[i]-cycle*(l-1))-sumv.begin())+(l-1)*n;*/
        }
        out(ans);
    }
}