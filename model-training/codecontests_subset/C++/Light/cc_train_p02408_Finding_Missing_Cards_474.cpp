#include<iostream>
using namespace std;

int main(){
    int n;
    cin>>n;
    bool ans[4][13]={};
    char ans_[4]={'S','H','C','D'};
    for(int i=0;i<n;i++){
        char mark;
        int m;
        cin>>mark>>m;
        if(mark=='S')ans[0][m-1]=1;
        if(mark=='H')ans[1][m-1]=1;
        if(mark=='C')ans[2][m-1]=1;
        if(mark=='D')ans[3][m-1]=1;
    }
    for(int j=0;j<4;j++){
        for(int k=0;k<13;k++){
            if(ans[j][k]==false){
                cout<<ans_[j]<<' '<<(k+1)<<endl;
            }
        }
    }
    return 0;
}
