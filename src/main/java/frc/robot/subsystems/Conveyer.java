package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.DeviceId;

public class Conveyer extends SubsystemBase {
    private final TalonFX motor;

    public Conveyer() {
        this.motor = new TalonFX(DeviceId.Conveyer.CONVEYER);

        TalonFXConfiguration config = new TalonFXConfiguration();
        config.MotorOutput
            .withNeutralMode(NeutralModeValue.Brake)
            .withInverted(InvertedValue.Clockwise_Positive);

        this.motor.getConfigurator().apply(config);
    }

    public void move(double speed) {
        SmartDashboard.putNumber("Talon Speed", speed * Constants.Conveyer.MAX_DRIVE_SPEED);
        this.motor.set(speed * Constants.Conveyer.MAX_DRIVE_SPEED);
    }

    public void stop() {
        this.motor.stopMotor();
    }
}