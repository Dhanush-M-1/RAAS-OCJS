#include <iostream>
using namespace std;

int main(){
    int N;
    cin >> N;

    char a;
    int b;
    int X[4][13] = {{}};
    char M[4] = {'S', 'H', 'C', 'D'};
    for (int n=0; n<N; n++){
        cin >> a >> b;
        for (int i=0; i<4; i++){
            for (int j=0; j<13; j++){
                if (a==M[i] && b==j+1) X[i][j]++;
            }   
        }   
    }   
        
    for (int i=0; i<4; i++){
       for (int j=0; j<13; j++){
           if (X[i][j]==0) cout << M[i] << ' ' << j+1 << endl;
       }   
    }   
}