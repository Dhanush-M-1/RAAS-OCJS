#include<bits/stdc++.h>
#define int long long
#define rep for(int i=0;i<n;++i)
#define per for(int i=n;i>0;--i)
#define FOR(i,a,b) for(int i=a;i<=b;++i)
#define ROF(i,a,b) for(int i=a;i>=b;--i)
using namespace std;
static const int INF =1<<61;
static const int MOD = 10000;
string num1,num2;
string s;
int m;
int mem[501][500][10][3][3];

int cal(int n,int mod,int p,int pp,int f){
    int res=0;
    if(mem[n][mod][p][pp][f]!=-1)return mem[n][mod][p][pp][f];
    if(n==s.size())return 0;
    FOR(i,0,9){
        int b=pp;
        int t=f;
        int temp=(mod*10);
        temp+=i;
        if(n==0){
           if(i==0)continue;
           if(i>s[n]-'0')t=1;
           else if(i<s[n]-'0')t=2;
           else t=0;
           if(s.size()==1){
              if(s[0]-'0'>i&&i%m==0)res+=cal(n+1,i%m,i,b,t)+1;
           }
           else{
               if(i%m==0){
                    res+=(cal(n+1,i%m,i,b,t)+1)%MOD;
               }
               else res+=cal(n+1,i%m,i,b,t);
           }
        }
        else if(n==1){
           if(t==0){
              if(i>s[n]-'0')t=1;
              else if(i<s[n]-'0')t=2;
           }
           if(p==i)continue;
           else if(p<i)b=1;
           else if(p>i)b=0;

           if(temp%m==0){
                res+=(cal(n+1,temp%m,i,b,t)+1)%MOD;
           }
           else res+=cal(n+1,temp%m,i,b,t);
        }
        else if(n==s.size()-1){
            if(t==0){
              if(i>s[n]-'0')t=1;
              else if(i<s[n]-'0')t=2;
            }
            if(t==2){
                if(b==1){
                    if(p>i){
                        if(temp%m==0){
                        res+=(cal(n+1,temp%m,i,b,t)+1)%MOD;
                        }
                   }
                }
                else if(b==0){
                if(p<i){
                    if(temp%m==0){
                        res+=(cal(n+1,temp%m,i,b,t)+1)%MOD;
                    }
                 }
              }
            }
            if(t==0){
                if(b==1){
                    if(p>i&&s[n]-'0'>=i){
                        if(temp%m==0){
                        res+=(cal(n+1,temp%m,i,b,t)+1)%MOD;
                        }
                   }
                }
                else if(b==0){
                if(p<i&&s[n]-'0'>=i){
                    if(temp%m==0){
                        res+=(cal(n+1,temp%m,i,b,t)+1)%MOD;
                    }
                 }
              }
            }
        }
        else{
            if(t==0){
               if(i>s[n]-'0')t=1;
               else if(i<s[n]-'0')t=2;
            }
            if(b==1){
                if(p>i){
                    b=0;
                    if(temp%m==0){
                        res+=(cal(n+1,temp%m,i,b,t)+1)%MOD;
                    }
                    else res+=cal(n+1,temp%m,i,b,t);
                }
            }
            else if(b==0){
                if(p<i){
                    b=1;
                    if(temp%m==0){
                        res+=(cal(n+1,temp%m,i,b,t)+1)%MOD;
                    }
                    else res+=cal(n+1,temp%m,i,b,t)%MOD;
                }
            }
        }
    }
    return mem[n][mod][p][pp][f]=res%MOD;
}


int vr,vl;
signed main(){
    cin>>num1>>num2;
    cin>>m;
    s=num1;
    memset(mem,-1,sizeof(mem));
    vl=cal(0,0,0,0,0)%MOD;
    memset(mem,-1,sizeof(mem));
    s=num2;
    vr=cal(0,0,0,0,0)%MOD;
    cout<<(vr-vl+MOD)%MOD<<endl;
    return 0;
}