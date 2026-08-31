#include <bits/stdc++.h>
using namespace std;

#define rep(i,x,y) for(int i=(x);i<(y);++i)
#define debug(x) #x << "=" << (x)

#ifdef DEBUG
#define _GLIBCXX_DEBUG
#define dump(x) std::cerr << debug(x) << " (L:" << __LINE__ << ")" << std::endl
#else
#define dump(x)
#endif

typedef long long int ll;
typedef pair<int,int> pii;
//template<typename T> using vec=std::vector<T>;

const int inf=1<<30;
const long long int infll=1LL<<58;
const double eps=1e-9;
const int dx[]={1,0,-1,0},dy[]={0,1,0,-1};

template <typename T> ostream &operator<<(ostream &os, const vector<T> &vec){
    os << "[";
    for (const auto &v : vec) {
    	os << v << ",";
    }
    os << "]";
    return os;
}

void solve(){
    while(true){
        int n;
        cin >> n;
        if(n==0) break;
        vector<vector<int>> schedule(n,vector<int>(16));
        rep(i,0,n) for(int& in:schedule[i]) cin >> in;

        set<tuple<int,int,int>> done;
        const int mask=(1<<3)-1;
        function<bool(int,int,int)> dfs=[&](int day,int pos,int cnt){
            tuple<int,int,int> state(day,pos,cnt);
            if(done.find(state)!=done.end()) return false;
            done.insert(state);
            if(schedule[day][pos] or schedule[day][pos+1] or schedule[day][pos+4] or schedule[day][pos+5]) return false;
            int cnt1=cnt&mask,cnt2=(cnt>>3)&mask,cnt3=(cnt>>6)&mask,cnt4=(cnt>>9)&mask;
            ++cnt1;
            ++cnt2;
            ++cnt3;
            ++cnt4;
            if(pos==0) cnt1=0;
            if(pos==2) cnt2=0;
            if(pos==8) cnt3=0;
            if(pos==10) cnt4=0;
            if(cnt1>6 or cnt2>6 or cnt3>6 or cnt4>6) return false;
            if(day==n-1) return true;
            int next_cnt=cnt1|(cnt2<<3)|(cnt3<<6)|(cnt4<<9);
            int x=pos%4,y=pos/4;
            bool res=false;
            rep(d1,-2,3) rep(d2,-2,3){
                if(d1!=0 and d2!=0) continue;
                int nx=x+d1,ny=y+d2;
                if(nx<0 or 2<nx or ny<0 or 2<ny) continue;
                int next_pos=nx+ny*4;
                res|=dfs(day+1,next_pos,next_cnt);

            }
            return res;
        };

        if(dfs(0,5,0)) cout << 1 << endl;
        else cout << 0 << endl;
    }
}

int main(){
    std::ios::sync_with_stdio(false);
    std::cin.tie(0);
    cout << fixed << setprecision(8);
    solve();
    return 0;
}