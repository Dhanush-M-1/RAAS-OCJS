#include<bits/stdc++.h>
#define LL lon long

using namespace std;

string s;
string str1,str2;
static const int MOD=10000;
int M;
int mem[501][10][3][3][500];

int cal(int n,int p,int pp,int f,int mod){
    int res=0;
    if(n==s.size()){
        if(mod==0)return 1;
        else return 0;
    }
    if(mem[n][p][pp][f][mod]!=-1)return mem[n][p][pp][f][mod];
    int t=9;
    if(f!=1)t=s[n]-'0';
    for(int i=0;i<=t;++i){
        if(pp==1&&p>=i)continue;
        else if(pp==0&&p<=i)continue;
        else if(pp==2&&p!=0&&p==i)continue;

        int b;
        if(pp==2){
            if(p==0)b=2;
            else if(p<i)b=0;
            else b=1;
        }
        else if(pp==1)b=0;
        else b=1;

        int k;
        if(f==1)k=1;
        else if(i!=s[n]-'0')k=1;
        else k=0;

        int temp=mod*10+i;
        if(temp==0)res+=cal(n+1,i,b,k,0);
        else res+=cal(n+1,i,b,k,temp%M);
    }
    return mem[n][p][pp][f][mod]=res%MOD;
}

int main(){
    int vr=0;
    int vl=0;
    cin>>str1>>str2>>M;
    s=str1;
    memset(mem,-1,sizeof(mem));
    vl=cal(0,0,2,0,0);
    s=str2;
    memset(mem,-1,sizeof(mem));
    vr=cal(0,0,2,0,0);
    if((str1[0]-'0')%M==0&&str1.size()==1)vl--;
    cout<<(vr-vl+MOD)%MOD<<endl;

    return 0;
}