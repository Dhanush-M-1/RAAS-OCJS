/*
    构造一个正交化的线性基
    实现完全正交 is impossible;
        退而求之局部正交,即crucial musk不能出现在其他向量中
    
    竟然要用并查集我日你先人(
*/

#include<bits/stdc++.h>
#define ll long long
using namespace std;
#define pb push_back
const int ha = 1e9+7;

inline int add(int x,int y){ x+=y; return x>=ha?x-ha:x;}
inline void ADD(int &x,int y){ x+=y; if(x>=ha) x-=ha;}

inline int ksm(int x,int y){
    int an=1;
    for(;y;y>>=1,x=x*(ll)x%ha) if(y&1) an=an*(ll)x%ha;
    return an;
}

class liner_base{
public:
    int n,*e,*hd,*ne,*tl;
    char *ex;

    liner_base(int N) : n(N){
        e = new int [N+5];  
        hd = new int [N+5];  
        ne = new int [N+5];
        tl = new int [N+5];
        ex = new char [N+5];
        memset(hd,0,sizeof(int)*(N+3));
        memset(ne,0,sizeof(int)*(N+3));
        memset(tl,0,sizeof(int)*(N+3));
        memset(ex,0,sizeof(char)*(N+3));
        for(int i=0;i<=N;i++)  e[i] = i;
    }

    ~liner_base(){
        /*
        delete e;
        delete hd;
        delete ne;
        delete tl;
        delete ex;
        */
    }

    int gete(int x){ return e[x] == x ? x : (e[x] = gete(e[x]));}

    inline void add_to_list(int Element,int List){
        ne[Element] = hd[List];
        e[Element] = List;
        hd[List] = Element;
        if(!tl[List]) tl[List] = Element;
    }

    void delete_list(int List){
        for(int now = hd[List],NE;now;now = NE)
            NE = ne[now] , e[now] = now , ne[now] = 0;
        hd[List] = tl[List] = 0;
    }

    inline void alter_list(int List1,int List2){
        if(!hd[List1]) return;
        if(!hd[List2]) hd[List2] = hd[List1],tl[List2] = tl[List1];
        else ne[tl[List2]] = hd[List1],tl[List2] = tl[List1];

        hd[List1] = tl[List1] = 0;
    }

    inline void add(int x){ /*printf("add %d\n",x),*/ex[x] = 1,e[x] = x,delete_list(x);}

    inline void add(int x,int y){ /*printf("add %d %d\n",x,y),*/ex[x] = 1,alter_list(x,y),add_to_list(x,y);}

    inline bool insert(int x){
        if(ex[x] && gete(x) == x) return 0;
        if(ex[x]) add(gete(x));
        else add(x);

        return 1;
    }

    inline bool insert(int x,int y){
        if(x == y) return 0;
        if(ex[x] && (gete(x) == x)) return insert(y);
        else if(ex[x]) return insert(min(gete(x),y),max(gete(x),y));
        else if(ex[y] && gete(y) == y) return insert(x);
        else if(ex[y]) return insert(x,gete(y));
        else add(x,y);
        return 1;
    }

    inline void consistent_check(){
        int *color = new int [n+5];
        memset(color,0,sizeof(int)*(n+3));

        for(int i=1;i<=n;i++)
            for(int j=hd[i];j;j=ne[j]) color[j] = i;
        for(int i=1;i<=n;i++) if(ex[i] && !color[i]) color[i] = i;
        
        for(int i=1;i<=n;i++) if(ex[i] && color[i] != gete(i)) 
			printf("There is an unconsistent with node %d\ncolor is %d, but father is %d\n",i,color[i],gete(i));

    }

    inline void check(){
        for(int i=1;i<=n;i++) if(ex[i]) printf("%d : %d\n",i,gete(i));
    }
};

int main(){
//    freopen("data.in","r",stdin);
//    freopen("data.out","w",stdout);

    int n,m; scanf("%d%d",&n,&m);
    liner_base a(m);
    queue<int> q;
    for(int opt,X,Y,i=1;i<=n;i++){
        scanf("%d",&opt);
        if(opt==1){
            scanf("%d",&X);
            if(a.insert(X)) q.push(i);
        }
        else{
            scanf("%d%d",&X,&Y);
            if(a.insert(min(X,Y),max(X,Y))) q.push(i);
        }
    }

//    a.consistent_check();

    printf("%d %d\n",ksm(2,q.size()),(int)q.size());
    while(!q.empty()) printf("%d ",q.front()),q.pop();
//    a.check();

    return 0;
}
