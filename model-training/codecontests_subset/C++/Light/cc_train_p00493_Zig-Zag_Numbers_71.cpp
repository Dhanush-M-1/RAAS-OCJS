#include<iostream>

using namespace std;
#define rep(i, a) for(int i=0; i<(a); i++)
string A, B;
int M;
int memo[502][2][4][10][500];
//pos, less, hoge, pre, modM
string S;
const int up=2, down=3;
const int mod=1e4;



int rec(int i, int j, int k, int l, int m){

    if(memo[i][j][k][l][m]!=-1) return memo[i][j][k][l][m];

    if(i==S.size()){
        return memo[i][j][k][l][m]=((k!=0)&&(m==0));

    }
    int ret=0;
    int ue=(j? 9: S[i]-'0');
    rep(d, ue+1){
        int diff=d-l;
        int nj=(j||d<ue);
        int nk;
        int nm=(10*m+d)%M;
        if(k==0){
            nk=(d!=0);
        }else if(k==1){
            if(diff==0) continue;
            nk=(diff>0? up: down);
        }else if(k==up&&diff<0){
            nk=down;
        }else if(k==down&&diff>0){
            nk=up;
        }else{
            continue;
        }
        (ret+=rec(i+1, nj, nk, d, nm))%=mod;
    }

    return memo[i][j][k][l][m]=(ret%mod);
}


int calc(string N){

    fill((int*)memo, (int*)memo+502*2*4*10*500, -1);
    S=N;
    return rec(0, 0, 0, 0, 0);
}

void minus1(){

    int len=A.size();
    for(int i=0; i<len; i++){
        char ch=A[len-1-i];
        if(ch=='0'){
            A[len-1-i]='9';
        }else{
            A[len-1-i]=ch-1;
            break;
        }
    }
    if(A[0]=='0'&&A.size()>1) A=A.substr(1);
}

int main(){

    cin>> A>> B>> M;

    minus1();
    cout<< (calc(B)-calc(A)+mod)%mod<< endl;

    return 0;
}