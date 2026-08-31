#include <cstdio>
#include <cstdlib>
#include <iostream>
#include <string>
#include <cmath>
#include <algorithm>
#include <vector>
#include <queue>
#include <stack>
#include <map>
#include <set>


using namespace std;
typedef long long ll;

#define mod 10000
#define INF 2000000000
#define LLINF 4000000000000000000
#define SIZE 50010

char A[510],B[510];
int M;

int memo[501][2][10][500][3];

// h=?????° Z = true->up false->down b=1???????????°??? m=(modM)
// a=0..???MAX&?????± 1..???MAX&??¶????????? 2..???MAX-1&?????± c=0..A 1..B

// O(500*2*10*500*3*2 = 15000000)

int MAX_a,C[510];

int dfs(int h,bool Z,int b,int m,int a){
    int ret = 0;
    
    if(h == MAX_a && a==2) return 0;
    
    if(m==0 && h > 0 && !(h==1 && Z==false))
        ret = 1;
    
    if((h == MAX_a) || (h == MAX_a-1 && a==2)){
        return ret;
    }
    
    if(memo[h][Z][b][m][a]>0){
        return memo[h][Z][b][m][a];
    }
    
    //[s,e)
    int s=0,e=10;
    
    if(h==0) s =1;
    
    if(Z==true){
        s = b+1;
    }else{
        e = b;
    }
    
    if(a == 1){
        
        for(int i=s;i<e;i++){
            if(C[h] < i)
                ret+=dfs(h+1,!Z,i,(m*10+i)%M,2);
            else if(C[h]==i)
                ret+=dfs(h+1,!Z,i,(m*10+i)%M,1);
            else
                ret+=dfs(h+1,!Z,i,(m*10+i)%M,0);
        }
        
    }else{
        for(int i=s;i<e;i++){
            ret+=dfs(h+1,!Z,i,(m*10+i)%M,a);
        }
    }
    
    memo[h][Z][b][m][a] = ret%mod;
    
    return ret%mod;
}

int is_ZigZag(){
    bool Z;
    
    if(MAX_a==1)
        return 1;
    
    if(C[0]==C[1])
        return 0;
    
    if(MAX_a==2){
        return 1;
    }
    
    Z = (C[0] > C[1]);
    
    for(int i=2;i<MAX_a;i++){
        if(!(Z==true && C[i-1] < C[i]) && !(Z==false && C[i-1] > C[i])){
            return 0;
        }
    }
    
    return 1;
}

int main(){
    int ans_A,ans_B,length_A=0,length_B=0;
    
    scanf("%s %s %d",A,B,&M);
    
    while(A[length_A]!='\0') length_A++;
    while(B[length_B]!='\0') length_B++;

    for(int i=0;i<length_A;i++){
        C[i] = A[i]-'0';
    }
    
    MAX_a = length_A;
    ans_A = dfs(0,1,-1,0,1) + dfs(0,0,10,0,1);
    
    ans_A -= is_ZigZag();
    
    for(int i=0;i<501;i++){
        for(int j=0;j<2;j++){
            for(int k=0;k<10;k++){
                for(int l=0;l<500;l++){
                    for(int m=0;m<3;m++){
                        memo[i][j][k][l][m] = 0;
                    }
                }
            }
        }
    }
    
    for(int i=0;i<length_B;i++){
        C[i] = B[i]-'0';
    }
    MAX_a = length_B;
    ans_B = dfs(0,1,-1,0,1) + dfs(0,0,10,0,1);
    
    
    printf("%d\n",(ans_B+mod-(ans_A%mod))%mod);
    
    return 0;
}