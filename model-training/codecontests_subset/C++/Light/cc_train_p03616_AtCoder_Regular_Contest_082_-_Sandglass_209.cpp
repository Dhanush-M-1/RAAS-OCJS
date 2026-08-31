#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
const int max_n=200005;
struct Node{
    int t,a,id;
    bool operator < (Node p)const {
        return t<p.t;
    }
}qry[max_n];
int X,k,q;
bool down;
int a,b,c;
void update(int v){
    int u=b-a+c;
    if(u+v>X){
        b-=u+v-X;
        c+=v;
        b=max(b,a),c=min(c,X);
    }
    else if(c+v<0){
        a-=c+v;
        c+=v;
        a=min(a,b),c=max(c,0);
    }
    else c+=v;
}
int query(int x){
    //cout<<x<<' '<<a<<' '<<b<<' '<<c<<endl;
    if(x<a)return c;
    else if(x>=a&&x<=b)return x-a+c;
    else return b-a+c;
}
int ans[max_n];
int main(){
    scanf("%d%d",&X,&k);
    for(int i=1;i<=k;i++){
        scanf("%d",&qry[i].t);
    }
    scanf("%d",&q);
    for(int i=1;i<=q;i++){
        scanf("%d%d",&qry[i+k].t,&qry[i+k].a);
        qry[i+k].id=i;
    }
    sort(qry+1,qry+q+k+1);
    down=true;
    a=0,b=X,c=0;
    for(int i=1;i<=q+k;i++){
        int x=qry[i].t-qry[i-1].t;
        if(down)update(-x);
        else update(x);
        //cout<<qry[i].t<<' '<<a<<' '<<b<<' '<<c<<endl;
        if(qry[i].id==0)down^=1;
        else ans[qry[i].id]=query(qry[i].a);
    }
    for(int i=1;i<=q;i++)printf("%d\n",ans[i]);
    return 0;
}
