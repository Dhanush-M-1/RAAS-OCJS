#include<bits/stdc++.h>
using namespace std;
 
vector<int> stov(string s){
    vector<int> res(s.size());
    for(int i=0;i<s.size();i++){
        res[i]=s[i]-'0';
    }
    return res;
}
void inc(vector<int>& n){
    for(int i=n.size()-1;i>=0;i--){
        if(n[i]<9){
            n[i]++;
            return;
        }
        n[i]=0;
    }
    n.insert(n.begin(),1);
}
 
using vi=vector<int>;
using vvi=vector<vi>;
using vvvi=vector<vvi>;
using vvvvi=vector<vvvi>;
const int SIZE=502;
const int MOD=10000;
const int BOTH=0;
const int LOWER=1;
const int UPPER=2;
 
int main(){
    string abuf,bbuf;
    cin>>abuf>>bbuf;
    int m;
    cin>>m;
    auto a=stov(abuf),b=stov(bbuf);
    inc(b);
 
    vvvvi dp(SIZE+1,vvvi(10,vvi(m,vi(3,0))));
    for(int i=0;i<10;i++){
        dp[1][i][i%m][BOTH]=1;
    }
    vector<int> tenv(SIZE,1);
    int ten=10%m;
    for(int i=1;i<SIZE;i++){
        tenv[i]=ten;
        for(int j=0;j<10;j++){
            for(int k=0;k<m;k++){
                for(int r=0;r<10;r++){
                    int tok=(k+r*ten)%m;
                    if(j<r){
                        (dp[i+1][r][tok][LOWER]+=dp[i][j][k][UPPER])%=MOD;
                        (dp[i+1][r][tok][LOWER]+=dp[i][j][k][BOTH])%=MOD;
                    }
                    if(r<j){
                        (dp[i+1][r][tok][UPPER]+=dp[i][j][k][LOWER])%=MOD;
                        (dp[i+1][r][tok][UPPER]+=dp[i][j][k][BOTH])%=MOD;
                    }
                     
                }
            }
        }
        ten=(ten*10)%m;
    }
     
    auto solve=[&](vector<int> &v){
        int res=0;
        for(int i=1;i<v.size();i++){
            for(int j=1;j<10;j++){
                res+=dp[i][j][0][LOWER];
                res+=dp[i][j][0][UPPER];
                res+=dp[i][j][0][BOTH];
                res%=MOD;
            }
        }
        for(int i=1;i<v[0];i++){
            res+=dp[v.size()][i][0][LOWER];
            res+=dp[v.size()][i][0][UPPER];
            res+=dp[v.size()][i][0][BOTH];
            res%=MOD;
        }
        int flag=BOTH;
        int cnt=(tenv[v.size()-1]*v[0])%m;
        for(int i=1;i<v.size();i++){
            for(int j=0;j<v[i];j++){
                int tok=(m-cnt)%m;
                if(v[i-1]<j){
                    if(flag==BOTH || flag==UPPER){
                        res+=dp[v.size()-i][j][tok][LOWER];   
                        res+=dp[v.size()-i][j][tok][BOTH];
                    }
                }
                if(v[i-1]>j){
                    if(flag==BOTH || flag==LOWER){
                        res+=dp[v.size()-i][j][tok][UPPER];   
                        res+=dp[v.size()-i][j][tok][BOTH];
                    }
                }
                res%=MOD;
            }
            if(v[i-1]<v[i]){
                if(flag==BOTH || flag==UPPER){
                    flag=LOWER;
                }
                else break;
            }
            else if(v[i-1]>v[i]){
                if(flag==BOTH || flag==LOWER){
                    flag=UPPER;
                }
                else break;
            }
            else break;
            cnt=(cnt+tenv[v.size()-1-i]*v[i])%m;
        }
        return res;
    };
    cout<<((solve(b)-solve(a))%MOD+MOD)%MOD<<endl;
    return 0;
}
