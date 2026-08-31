#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
#include <queue>
#include <set>

using namespace std;

typedef long long ll;

int n;
//// eóÔ©çS[Ö½Çè¯é©Ç¤©ðCY
//map<ll,bool> dp[3][3];
//
// óÔsÌidxÔÚÌlðæèo·
int getValue(ll s,int idx){
    int b1=((s>>idx*3)&1);
    int b2=((s>>idx*3+1)&1);
    int b3=((s>>idx*3+2)&1);
    return b1+2*b2+4*b3;
}
// óÔsÌidxÔÚÉlxðZbg
void setValue(ll &s,int idx,int x){
    int b1=((x>>0)&1);
    int b2=((x>>1)&1);
    int b3=((x>>2)&1);
    if(b1==0)
        s&=~(1LL<<idx*3);
    else
        s|=(1LL<<idx*3);
    if(b2==0)
        s&=~(1LL<<(idx*3+1));
    else
        s|=(1LL<<(idx*3+1));
    if(b3==0)
        s&=~(1LL<<(idx*3+2));
    else
        s|=(1LL<<(idx*3+2));
}
//
//
//// placeÍ_Ì¶ãÌÊu
//bool dfs(ll s,int cy,int cx){
//    if(dp[cy][cx].find(s)!=dp[cy][cx].end())
//        return dp[cy][cx][s];
//    // eûüÖÚ®
//    for(int i = 0; i < 9; i++){
//        int ny=cy+dy[i];
//        int nx=cx+dx[i];
//        // ÍÝoÈ¢ê
//        if(ny>=0&&nx>=0&&ny<3&&nx<3){
//            bool res=(dfs(s,ny,nx));
//            if(res)return dp[cy][cx][s]=res;
//        }
//    }
//    return dp[cy][cx][s]=false;
//}

const int dy[]={-2,-1,0,1,2,0,0,0,0};
const int dx[]={0,0,0,0,0,-1,-2,1,2};
typedef pair<ll,pair<int,int> > P;

int field[370][4][4];
void solve(){
    queue<P> *prv=new queue<P>();
    queue<P> *nxt=new queue<P>();
    while(cin>>n&&n!=0){
        for(int i = 0; i < n; i++)
            for(int j = 0; j < 4; j++)
                for(int k = 0; k < 4; k++)
                    cin>>field[i][j][k];
        int idx=0;
        bool ok=false;
        bool fin=false;
        // úÊuªÃ©`FbN
        for(int i = 1; i < 3; i++){
            for(int j = 1; j <3; j++){
                if(field[idx][i][j]){
                    fin=true;
                    break;
                }
            }
            if(fin)break;
        }
        idx++;
        ll init=0;
        for(int i = 0; i < 4; i++){
            for(int j = 0;j < 4; j++){
                if(i==0||j==0||i==3||j==3)
                    setValue(init,i*4+j,6);
                else
                    setValue(init,i*4+j,7);
            }
        }
        prv->push(make_pair(init,make_pair(1,1)));
        while(!fin&&prv->size()){
            set<ll> passed[10];
            while(prv->size()){
                ll cs=prv->front().first;
                int cy=prv->front().second.first;
                int cx=prv->front().second.second;
                prv->pop();
                // eûüÖÚ®
                for(int i = 0; i < 9; i++){
                    ll ns=cs;
                    int ny=cy+dy[i];
                    int nx=cx+dx[i];
                    // ÍÝoÈ¢©ÂÚ®æÉÕèª¶ÝµÈ¢
                    if(ny>=0&&nx>=0&&ny<3&&nx<3){
                        bool moveOK=true;
                        // Ú®æÉÕèª¶ÝµÈ¢ÌªÚ®Ìð
                        for(int j = 0; j < 2; j++){
                            for(int k = 0; k < 2; k++){
                                if(field[idx][ny+j][nx+k]){
                                    moveOK=false;
                                    break;
                                }
                            }
                            if(!moveOK)break;
                        }
                        if(!moveOK)continue;
                        // ±±ÅÚ®
                        // »ê¼êÌêÌð1ÂÖç·
                        for(int j = 0; j < 4; j++)
                            for(int k = 0; k < 4; k++)
                                setValue(ns,j*4+k,getValue(ns,j*4+k)-1);
                        // ¡ñÌÍÍð7Éß·
                        for(int j = ny; j < ny+2; j++)
                            for(int k = nx; k < nx+2; k++)
                                setValue(ns,j*4+k,7);
                        // zero`FbN
                        for(int j = 0; j < 4; j++){
                            for(int k = 0; k < 4; k++){
                                if(getValue(ns,j*4+k)==0){
                                    moveOK=false;
                                    break;
                                }
                            }
                            if(!moveOK)break;
                        }
                        if(!moveOK)continue;
                        if(passed[ny*3+nx].find(ns)==passed[ny*3+nx].end()){
                            nxt->push(make_pair(ns,make_pair(ny,nx)));
                            passed[ny*3+nx].insert(ns);
                        }
                    }
                }
            }
            swap(prv,nxt);
            idx++;
            if(idx==n){
                if(prv->size()>=1){
                    while(prv->size())prv->pop();
                    ok=true;
                }
                break;
            }
        }
        if(ok)cout<<1<<endl;
        else cout<<0<<endl;
    }
    delete prv;
    delete nxt;
 }

int main(){

    solve();

    return 0;
}