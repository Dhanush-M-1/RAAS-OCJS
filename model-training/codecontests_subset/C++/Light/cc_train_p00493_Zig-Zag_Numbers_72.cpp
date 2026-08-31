#include<bits/stdc++.h>
using namespace std;
const int mod=10000;
string A,B,S;
int M;

int memo[501][10][3][2][500];

int calc(int keta=0,int mae=0,int hoko=0,int jiyuu=0,int amari=0){
    if(keta==S.size()){
        return amari==0;
    }
    if(~memo[keta][mae][hoko][jiyuu][amari])
        return memo[keta][mae][hoko][jiyuu][amari];

    int ret=0;
    for(int i=0;i<10;i++){
        if(jiyuu==0&&S[keta]<i+'0')break;
        if((hoko||mae)&&mae==i)continue;
        int njiyuu=jiyuu|(i+'0'!=S[keta]);
        int namari=(amari*10+i)%M;
        if(hoko==0){
            if(mae)ret=(ret+calc(keta+1,i,mae<i?2:1,njiyuu,namari))%mod;
            else ret=(ret+calc(keta+1,i,0,njiyuu,namari))%mod;
        }
        else if(hoko==1&&mae<i){
            ret=(ret+calc(keta+1,i,2,njiyuu,namari))%mod;
        }
        else if(hoko==2&&mae>i){
            ret=(ret+calc(keta+1,i,1,njiyuu,namari))%mod;
        }
    }
    return memo[keta][mae][hoko][jiyuu][amari]=ret;
}

int main(){
    cin>>A>>B>>M;
    A[A.size()-1]--;
    for(int i=A.size()-1;i>0;i--){
        if(A[i]>='0')break;
        A[i]='9';
        A[i-1]--;
    }

    S=B;memset(memo,-1,sizeof(memo));
    int vb=calc();

    S=A;memset(memo,-1,sizeof(memo));
    int va=calc();

    cout<<(vb-va+mod)%mod<<endl;

    return 0;
}