#include <iostream>
#include <cstring>
#include <string>

using namespace std;

string sa,sb;
int a[501],b[501];
int m,mod=10000;
int dp[502][501][10][4][2];

int solve(int d[],int sz,bool low){
    memset(dp,0,sizeof(dp));
    dp[0][0][0][0][0]=1;
    for(int i=0;i<sz;++i){
        for(int j=0;j<m;++j){
            for (int k=0;k<10;++k){
                for(int l=0;l<4;++l){
                    for(int p=0;p<2;++p){
                        int lim=p?9:d[i];
                        for(int q=0;q<=lim;++q){
                            if(l==0)(dp[i+1][q%m][q][q!=0][p||q<lim] +=dp[i][j][k][l][p])%=mod;
                            else if(l==1&&q!=k)(dp[i+1][(j*10+q)%m][q][q<k?2:3][p||q<lim] +=dp[i][j][k][l][p])%=mod;
                            else if(l==2&&q>k)(dp[i+1][(j*10+q)%m][q][3][p||q<lim] +=dp[i][j][k][l][p])%=mod;
                            else if(l==3&&q<k)(dp[i+1][(j*10+q)%m][q][2][p||q<lim] +=dp[i][j][k][l][p])%=mod;
                        }
                    }
                }
            }
        }
    }
    int res=0;
    for(int i=0;i<10;++i){
        for(int j=0;j<4;++j){
            for(int k=0;k<2;++k){
                if(low&&k==0) continue;
                (res += dp[sz][0][i][j][k])%=mod;
            }
        }
    }
    return res;
}

int main(){
    cin>>sa>>sb>>m;
    for(int i=0;i<sb.size();++i) b[i]=sb[i]-'0';
    for(int i=0;i<sa.size();++i) a[i]=sa[i]-'0';
    cout<<(solve(b,sb.size(),false)-solve(a,sa.size(),true)+mod)%mod<<endl;
    return 0;
}