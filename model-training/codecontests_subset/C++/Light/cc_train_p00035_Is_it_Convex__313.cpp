#include<iostream>
#include<float.h>
using namespace std;

double pos[4][2];
int solve(){
    double a, b, c, d;
    a = (pos[0][1] - pos[2][1])*(pos[1][0] - pos[0][0]);
    a -= (pos[0][0] - pos[2][0])*(pos[1][1] - pos[0][1]);
    b = (pos[0][1] - pos[2][1])*(pos[3][0] - pos[0][0]);
    b -= (pos[0][0] - pos[2][0])*(pos[3][1] - pos[0][1]);
    c = (pos[1][1] - pos[3][1])*(pos[0][0] - pos[1][0]);
    c -= (pos[1][0] - pos[3][0])*(pos[0][1] - pos[1][1]);
    d = (pos[1][1] - pos[3][1])*(pos[2][0] - pos[1][0]);
    d -= (pos[1][0] - pos[3][0])*(pos[2][1] - pos[1][1]);
    if(a*b<=0 && c*d<=0){
        return true;
    }else{
        return false;
    }
}
int main(){
    int i, j;
    char comma;
    while(cin >> pos[0][0]){
        cin >> comma >> pos[0][1];
        for(i=1;i<4;i++){
            for(j=0;j<2;j++){
                cin >> comma >> pos[i][j];
            }
        }
        if(solve()){
            cout << "YES" << endl;
        }else{
            cout << "NO" << endl;
        }
    }
}