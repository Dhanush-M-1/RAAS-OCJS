#include    <iostream>

using namespace std;

// A[x,y]、B[x,y]を通る直線とC[x,y]、D[x,y]を結ぶ線分の交差判定を返す。
// 「((ax - bx)*(cy - ay)+(ay - by)*(ax - cx))*((ax - bx)*(dy - ay)+(ay - by)*(ax - dx))」
bool cross(double* a, double* b, double* c, double* d) {
    return ((a[0]-b[0])*(c[1]-a[1])+(a[1]-b[1])*(a[0]-c[0]))*((a[0]-b[0])*(d[1]-a[1])+(a[1]-b[1])*(a[0]-d[0])) > 0.0;
}

int main() {
    // 四角形ABCDの対角線ACとBDの線分が交差するか否かで判定可能である。
    // 線分同士を直接比較するのは難しいため、片方を直線とみなした上で、
    // 「直線と線分の交差判定」をする事で可能となる。
    
    double pos[4][2];
    while(~scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",
        &pos[0][0], &pos[0][1], &pos[1][0], &pos[1][1], &pos[2][0], &pos[2][1], &pos[3][0], &pos[3][1])) {
        
        cout << (cross(pos[0],pos[1],pos[2],pos[3]) && cross(pos[2],pos[3],pos[0],pos[1]) ? "YES" : "NO") << endl;
    }

    return 0;
}
