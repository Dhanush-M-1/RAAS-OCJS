#include<bits/stdc++.h>
using namespace std;
int main(){
    int N;
    cin>>N;
    bool A[4][14];
    for(int i=0;i<4;i++)
        for(int j=1;j<14;j++)A[i][j]=false;
    while(N--){
        char c;
        int n;
        cin>>c>>n;
        if(c=='S')A[0][n]=true;
        else if(c=='H')A[1][n]=true;
        else if(c=='C')A[2][n]=true;
        else A[3][n]=true;
    }
    string S="SHCD";
    for(int i=0;i<4;i++)
        for(int j=1;j<=13;j++)
            if(!A[i][j])cout<<S[i]<<' '<<j<<'\n';
}
