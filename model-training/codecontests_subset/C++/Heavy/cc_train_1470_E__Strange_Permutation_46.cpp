/*
Problem : 
Algorithm : 
Status : 
*/
#include<bits/stdc++.h>
#include<iostream>
#include<cstring>
#include<cstdio>
#include<algorithm>
#include<cstdlib>
#define DEBUG cerr << "Passing Line " << __LINE__<< " in Function [" << __FUNCTION__ << "].\n";
using namespace std;
typedef long long ll;
typedef pair<int,int> pii;
template<class T> inline bool checkMax(T &a,const T &b) {return a < b ? a = b,1 : 0;}
template<typename T, typename...Args> inline void checkMax(T &a,const Args...arg) {checkMax(a,max(arg...));}
template<class T> inline bool checkMin(T &a,const T &b) {return a > b ? a = b,1 : 0;}
template<typename T, typename...Args> inline void checkMin(T &a,const Args...arg) {checkMin(a,min(arg...));}

namespace FastIO{
    const int SIZE = 1 << 21;
    char ch;
    char in[SIZE],*inS = in,*inT = in + SIZE;
    char out[SIZE],*outS = out,*outT = out + SIZE;

    #define flush() fwrite(out,1,outS - out,stdout), outS = out
    #define getchar() (inS == inT && (inT = (inS = in) + fread(in,1,SIZE,stdin),inS == inT) ? EOF : *inS++)
    void putchar(char c) {*outS++ = c; if(outS == outT) flush();}

    struct Flusher {~Flusher() {flush();}} flusher;

    template<typename T> inline void read(T &x){
        static int f; x = 0; f = 1; ch = getchar();
        while(!isdigit(ch)) {if(ch == '-') f = -1; ch = getchar();}
        while(isdigit(ch)) {x = (x << 1) + (x << 3) + (ch ^ 48); ch = getchar();} x *= f;
    }

    inline void read(char* s){
        static int len; len = 0; ch = getchar();
        while(ch == '\n' || ch == ' ' || ch == '\0') ch = getchar();
        while(ch != '\n' && ch != ' ' && ch != EOF) s[len++] = ch, ch = getchar(); s[len] = '\0';
    }    

    template<typename T> inline void write(T x){
        if(!x) putchar('0');
        if(x < 0) {x = -x; putchar('-');}
        static int sta[20]; int tot = 0;
        while(x) {sta[tot++] = x % 10; x /= 10;}
        while(tot) putchar(sta[--tot] + 48);
    }

    inline void write(char c) {putchar(c);}
    template<typename T> inline void writeln(T c) {write(c); putchar('\n');}

    template<typename T,typename... Args> inline void read(T &t, Args &...args) {read(t); read(args...);}
}

using FastIO::read;
using FastIO::write;
using FastIO::writeln;

const int INF = 0x3f3f3f3f;
const ll llINF = 1e18;
const int MAXN = 6e4 + 5;
const int MAXC = 5;

int n,C,Q,T;
int cnt[MAXC][MAXN],p[MAXN];
ll comb[MAXN][MAXC],w[MAXC][MAXN * MAXC];

struct Node{
    int l,r; ll w;
    Node(int _l = 0,int _r = 0,ll _w = 0) : l(_l), r(_r), w(_w) {}
};

struct Deque{
    int head,tail;
    Node a[MAXN * MAXC * 2 + 100];

    Node& operator [] (const int &i) {return a[head + i - 1];}

    void push_front(Node u) {a[--head] = u; assert(head >= 1);}
    void push_back(Node u) {a[++tail] = u; assert(tail < MAXN * MAXC * 2 + 100);}
    void clear() {head = MAXN * MAXC + 5, tail = MAXN * MAXC + 4;}
    int size() {return tail - head + 1;}
    Deque() {clear();}
} q[MAXC];

void Init(int n){
    comb[0][0] = 1;
    for(int i = 1;i <= n;i++){
        comb[i][0] = 1;
        for(int j = 1;j <= min(MAXC - 1,i);j++)
            comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
    }
    for(int i = 0;i <= n;i++){
        for(int j = 1;j < MAXC;j++) comb[i][j] += comb[i][j - 1];
    }
}

ll calc(int n,int c){
    if(n <= 0) return 1;
    assert(n < MAXN);
    return comb[n - 1][c];
}

bool cmp(const Node &x,const Node &y){
    return p[x.r] < p[y.r];
}

Node GetNxt(int c,int pos,ll rk){
    int num = cnt[c][pos];
    int l = num + 1, r = q[c].size(), res = 0;
    while(l <= r){
        int mid = (l + r) >> 1;
        if(w[c][mid] - w[c][num] >= rk) res = mid, r = mid - 1;
        else l = mid + 1;
    }
    assert(res >= 1 && res <= q[c].size());
    return Node(q[c][res].l,q[c][res].r,w[c][res - 1] - w[c][num]);
}

void Solve(){
    read(n,C,Q);
    for(int i = 1;i <= n;i++) read(p[i]);
    for(int c = 1;c <= C;c++){
        q[c].clear(); vector<Node> front,back; 
        for(int i = 1;i <= n;i++) cnt[c][i] = 0;
        q[c].push_back(Node(n,n,1));
        for(int i = n - 1;i >= 1;i--){
            front.clear(); back.clear();
            for(int j = 1;j <= min(c,n - i);j++){
                if(p[i + j] < p[i])
                    front.emplace_back(i,i + j,calc(n - i - j,c - j)), cnt[c][i + 1] += 1;
                else back.emplace_back(i,i + j,calc(n - i - j,c - j));
            }
            sort(front.begin(),front.end(),cmp); reverse(front.begin(),front.end());
            sort(back.begin(),back.end(),cmp);
            for(auto x : front) q[c].push_front(x);
            for(auto x : back) q[c].push_back(x);
        }
        for(int i = 1;i <= n;i++) cnt[c][i] += cnt[c][i - 1];
        assert(q[c].size() <= MAXN * MAXC + 5);
        for(int i = 1, sz = q[c].size();i <= sz;i++)
            w[c][i] = w[c][i - 1] + q[c][i].w;
    }
    while(Q--){
        int pos; ll rk; read(pos,rk);
        if(rk > calc(n,C)) {writeln(-1); continue;}
        int x = 1, c = C; vector<pii> vec; vec.clear();
        while(c && x <= n){
            Node res = GetNxt(c,x,rk);
            assert(res.w < rk);
            rk -= res.w; c -= (res.r - res.l); x = res.r + 1;
            vec.emplace_back(res.l,res.r);
        }
        int flag = 0;
        for(auto pi : vec){
            if(pos >= pi.first && pos <= pi.second){
                writeln(p[pi.second - pos + pi.first]);
                flag = 1; break;
            }
        }
        if(!flag) writeln(p[pos]);
    }
}

int main(){
//    freopen("data.in","r",stdin);
//    freopen("data.out","w",stdout);
    Init(MAXN - 1); read(T); while(T--) Solve();
    return 0;
}
