#include<iostream>
using namespace std;
#define F(i,s,e) for(int i=s;i<e;++i)

int main(){
    int n;
    cin >> n;
    char m;
    int x;
    char M[4]={'S','H','C','D'};
    int N[4][13];
    F(i,0,13){
        F(j,0,4){
            N[j][i]=i+1;
        }
    }
    F(i,0,n){
        cin >> m >> x;
        F(j,0,4) if(m==M[j]) N[j][x-1]=0;
    }
    F(i,0,4)
        F(j,0,13)
            if(N[i][j]>0) cout << M[i] << ' ' << N[i][j] << endl;
    return 0;
}
